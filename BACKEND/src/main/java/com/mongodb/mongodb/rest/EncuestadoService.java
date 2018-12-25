package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Encuestado;
import com.mongodb.mongodb.model.Filtro;
import com.mongodb.mongodb.repository.EncuestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.*;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/encuestados")
public class EncuestadoService extends AbstractoService{

    @Autowired
    EncuestadoRepository encuestadoRepository;

    //Get All Encuestados
    @GetMapping(value="/all")
    public ResponseEntity getAllEncuestados(){
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado.",HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>(encuestadoRepository.findAll(),HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody Encuestado resource){ return new ResponseEntity<>(encuestadoRepository.save(resource),HttpStatus.CREATED);}

    @RequestMapping(method = RequestMethod.POST, value = "/graphics")
    @ResponseBody
    public ResponseEntity graphics(@RequestBody Filtro filtro){
        if(!isAuthorized(1))
            return new ResponseEntity<>("No está autorizado",HttpStatus.UNAUTHORIZED);

        //Fechas para arreglar
        System.out.println();
        System.out.println(filtro.getFechaInicial());
        System.out.println(filtro.getFechaFinal());
        System.out.println();

        //Procedimiento
        Map<String,Integer> jsonResultados = new HashMap<String,Integer>();
        List<Encuestado> lista = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),filtro.getFechaInicial(),filtro.getFechaFinal());
        List<Integer> sumaResultado = sumaEncuestas(lista,filtro.getCategoria_id());
        if(sumaResultado != null){
            Integer aprobacion = sumaResultado.get(4)+sumaResultado.get(5)+sumaResultado.get(6);
            Integer rechazo = sumaResultado.get(0)+sumaResultado.get(1)+sumaResultado.get(2);
            jsonResultados.put("Aprobados",aprobacion);
            jsonResultados.put("Rechazados",rechazo);
            jsonResultados.put("Neutro",sumaResultado.get(3));
            jsonResultados.put("Total Preguntas",aprobacion+rechazo+sumaResultado.get(3));
        }else{
            jsonResultados.put("Aprobados",0);
            jsonResultados.put("Rechazados",0);
            jsonResultados.put("Neutro",0);
            jsonResultados.put("Total Preguntas",0);
        }
        return new ResponseEntity<>(jsonResultados,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/graphicsSD")
    @ResponseBody
    public ResponseEntity graphicsWithSD(@RequestBody Filtro filtro){
        if(!isAuthorized(1))
            return new ResponseEntity<>("No está autorizado",HttpStatus.UNAUTHORIZED);

        //Fechas para arreglar
        System.out.println();
        System.out.println(filtro.getFechaInicial());
        System.out.println(filtro.getFechaFinal());
        System.out.println();

        //Procedimiento
        Map<String,Map<String,Integer>> jsonResultados = new HashMap<String,Map<String, Integer>>();

        switch (filtro.getVariableSD()){
            case "nivel de estudios":
                List<String> opciones = new ArrayList<>();
                Collections.addAll(opciones,"Básica incompleta","Básica completa","Media incompleta","Media completa","Técnico (o instituto profesional) incompleto","Técnico (o instituto profesional) completo","Universitario incompleto","Universitario completo","Estudios de postgrado incompleto","Estudios de postgrado completo","Otro","No sabe-No Responde");
                List<Encuestado> lista1 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(0),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista2 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(1),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista3 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(2),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista4 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(3),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista5 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(4),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista6 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(5),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista7 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(6),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista8 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(7),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista9 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(8),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista10 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(9),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista11 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(10),filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista12 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(11),filtro.getFechaInicial(),filtro.getFechaFinal());

                List<List<Encuestado>> listaCompleta = new ArrayList<>();
                Collections.addAll(listaCompleta,lista1,lista2,lista3,lista4,lista5,lista6,lista7,lista8,lista9,lista10,lista11,lista12);
                jsonResultados = calculoSumaTotal(listaCompleta,opciones,filtro.getCategoria_id());
                break;

            case "situacion laboral":
                opciones = new ArrayList<>();
                Collections.addAll(opciones,"Trabaja part time","Trabaja full time","Busca empleo", "Dueña de Casa","Jubilado","Estudiante","No sabe-No responde");
                lista1 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSituacionLaboralAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(0),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista2 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSituacionLaboralAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(1),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista3 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSituacionLaboralAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(2),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista4 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSituacionLaboralAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(3),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista5 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSituacionLaboralAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(4),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista6 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSituacionLaboralAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(5),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista7 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSituacionLaboralAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(6),filtro.getFechaInicial(),filtro.getFechaFinal());

                listaCompleta = new ArrayList<>();
                Collections.addAll(listaCompleta,lista1,lista2,lista3,lista4,lista5,lista6,lista7);
                jsonResultados = calculoSumaTotal(listaCompleta,opciones,filtro.getCategoria_id());
                break;

            case "nivel de ingresos":
                opciones = new ArrayList<>();
                Collections.addAll(opciones,"Menos de 150.000","Entre 150.001 y 250.000","Entre 250.001 y 450.000","Entre 450.001 y 750.000","Entre 750.001 y 1.000.000","Entre 1.000.001 y 1.500.000", "Entre 1.500.001 y 2.000.000", "Entre 2.000.001 y 3.000.000", "Más de 3.000.001", "No sabe-No responde");
                lista1 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(0),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista2 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(1),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista3 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(2),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista4 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(3),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista5 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(4),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista6 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(5),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista7 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(6),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista8 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(7),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista9 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(8),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista10 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeIngresoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(9),filtro.getFechaInicial(),filtro.getFechaFinal());

                listaCompleta = new ArrayList<>();
                Collections.addAll(listaCompleta,lista1,lista2,lista3,lista4,lista5,lista6,lista7,lista8,lista9,lista10);
                jsonResultados = calculoSumaTotal(listaCompleta,opciones,filtro.getCategoria_id());
                break;

            case "genero":
                opciones = new ArrayList<>();
                Collections.addAll(opciones,"Masculino","Femenino","No binario");
                lista1 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSexoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(0),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista2 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSexoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(1),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista3 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndSexoAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(2),filtro.getFechaInicial(),filtro.getFechaFinal());

                listaCompleta = new ArrayList<>();
                Collections.addAll(listaCompleta,lista1,lista2,lista3);
                jsonResultados = calculoSumaTotal(listaCompleta,opciones,filtro.getCategoria_id());
                break;

            case "estado civil":
                opciones = new ArrayList<>();
                Collections.addAll(opciones,"Casada(o)","Soltera(o)","Divorciada(o) o Separada(o)","Viuda(o)","Otro","No sabe-No responde");
                lista1 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndEstadoCivilAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(0),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista2 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndEstadoCivilAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(1),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista3 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndEstadoCivilAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(2),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista4 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndEstadoCivilAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(3),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista5 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndEstadoCivilAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(4),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista6 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndEstadoCivilAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(5),filtro.getFechaInicial(),filtro.getFechaFinal());

                listaCompleta = new ArrayList<>();
                Collections.addAll(listaCompleta,lista1,lista2,lista3,lista4,lista5,lista6);
                jsonResultados = calculoSumaTotal(listaCompleta,opciones,filtro.getCategoria_id());
                break;

            case "edad":
                opciones = new ArrayList<>();
                Collections.addAll(opciones,"Entre 18 y 24", "Entre 25 y 34","Entre 35 y 44","Entre 45 y 54","Entre 55 y 64","Mayor de 65", "No sabe-No responde");
                lista1 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndRangoDeEdadAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(0),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista2 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndRangoDeEdadAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(1),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista3 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndRangoDeEdadAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(2),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista4 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndRangoDeEdadAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(3),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista5 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndRangoDeEdadAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(4),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista6 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndRangoDeEdadAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(5),filtro.getFechaInicial(),filtro.getFechaFinal());
                lista7 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndRangoDeEdadAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),opciones.get(6),filtro.getFechaInicial(),filtro.getFechaFinal());
                listaCompleta = new ArrayList<>();
                Collections.addAll(listaCompleta,lista1,lista2,lista3,lista4,lista5,lista6,lista7);
                jsonResultados = calculoSumaTotal(listaCompleta,opciones,filtro.getCategoria_id());
                break;
            default:
                return new ResponseEntity<>("Variable Sociodemográfica incorrecta", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jsonResultados,HttpStatus.OK);
    }

    private Map<String, Map<String, Integer>> calculoSumaTotal(List<List<Encuestado>> listaCompleta, List<String> opciones, String categoriaID){
        Map<String,Map<String,Integer>> jsonResultados = new HashMap<String,Map<String, Integer>>();
        List<Integer> sumaResultado;
        for(int i = 0; i < listaCompleta.size(); i++){
            Map<String, Integer> partialRes = new HashMap<String, Integer>();
            sumaResultado = sumaEncuestas(listaCompleta.get(i),categoriaID);
            if(sumaResultado != null){
                Integer aprobacion = sumaResultado.get(4)+sumaResultado.get(5)+sumaResultado.get(6);
                Integer rechazo = sumaResultado.get(0)+sumaResultado.get(1)+sumaResultado.get(2);
                partialRes.put("Aprobados",aprobacion);
                partialRes.put("Rechazados",rechazo);
                partialRes.put("Neutro",sumaResultado.get(3));
                partialRes.put("Total Preguntas",aprobacion+rechazo+sumaResultado.get(3));
                jsonResultados.put(opciones.get(i),partialRes);
            }else{
                partialRes.put("Aprobados",0);
                partialRes.put("Rechazados",0);
                partialRes.put("Neutro",0);
                partialRes.put("Total Preguntas",0);
                jsonResultados.put(opciones.get(i),partialRes);
            }
        }
        return jsonResultados;
    }

    private List<Integer> sumaEncuestas(List<Encuestado> lista, String categoriaID){
        if(lista.isEmpty()){
            return null;
        }else{
            List<Integer> sumaResultado = new ArrayList<Integer>(Collections.nCopies(7, 0));//asignar 0's
            for(int i = 0; i < lista.size(); i++){
                for(int j = 0; j < lista.get(i).getResultados().size(); j++){
                    if(lista.get(i).getResultados().get(j).getIDCategoria().equals(categoriaID)){
                        List<Integer> res = lista.get(i).getResultados().get(j).getRespuesta();
                        for(int k = 0; k < res.size(); k++){
                            Integer indice = res.get(k);
                            Integer suma = sumaResultado.get(indice-1)+1;
                            sumaResultado.set(indice-1,suma);
                        }
                        j = lista.get(i).getResultados().size();
                    }
                }
            }
            return sumaResultado;
        }
    }
}

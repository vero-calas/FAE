package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Encuestado;
import com.mongodb.mongodb.model.Filtro;
import com.mongodb.mongodb.repository.EncuestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Map<String,Integer> graphics(@RequestBody Filtro filtro){
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
            jsonResultados.put("Total Encuestas",aprobacion+rechazo+sumaResultado.get(3));
        }else{
            jsonResultados.put("Aprobados",0);
            jsonResultados.put("Rechazados",0);
            jsonResultados.put("Neutro",0);
            jsonResultados.put("Total Encuestas",0);
        }
        return jsonResultados;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/graphicsSD")
    @ResponseBody
    public Map<String, Map<String,Integer>> graphicsWithSD(@RequestBody Filtro filtro){
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
                List<Encuestado> lista1 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Básica incompleta",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista2 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Básica completa",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista3 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Media incompleta",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista4 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Media completa",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista5 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Técnico (o instituto profesional) incompleto",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista6 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Técnico (o instituto profesional) completo",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista7 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Universitario incompleto",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista8 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Universitario completo",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista9 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Estudios de postgrado incompleto",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista10 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Estudios de postgrado completo",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista11 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"Otro",filtro.getFechaInicial(),filtro.getFechaFinal());
                List<Encuestado> lista12 = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndNivelDeEstudioAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),"No sabe-No Responde",filtro.getFechaInicial(),filtro.getFechaFinal());

                List<List<Encuestado>> listaCompleta = new ArrayList<>();
                Collections.addAll(listaCompleta,lista1,lista2,lista3,lista4,lista5,lista6,lista7,lista8,lista9,lista10,lista11,lista12);

                List<Integer> sumaResultado;
                for(int i = 0; i < listaCompleta.size(); i++){
                    Map<String, Integer> partialRes = new HashMap<String, Integer>();
                    sumaResultado = sumaEncuestas(listaCompleta.get(i),filtro.getCategoria_id());
                    if(sumaResultado != null){
                        Integer aprobacion = sumaResultado.get(4)+sumaResultado.get(5)+sumaResultado.get(6);
                        Integer rechazo = sumaResultado.get(0)+sumaResultado.get(1)+sumaResultado.get(2);
                        partialRes.put("Aprobados",aprobacion);
                        partialRes.put("Rechazados",rechazo);
                        partialRes.put("Neutro",sumaResultado.get(3));
                        partialRes.put("Total Encuestas",aprobacion+rechazo+sumaResultado.get(3));
                        jsonResultados.put(opciones.get(i),partialRes);
                    }else{
                        partialRes.put("Aprobados",0);
                        partialRes.put("Rechazados",0);
                        partialRes.put("Neutro",0);
                        partialRes.put("Total Encuestas",0);
                        jsonResultados.put(opciones.get(i),partialRes);
                    }
                }
            break;
            case "situacion laboral":
                break;
            case "ingresos":
                break;
            case "genero":
                break;
            case "estado civil":
                break;
            case "edad":
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

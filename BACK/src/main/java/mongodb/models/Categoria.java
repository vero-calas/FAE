package mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "categorias")
public class Categoria {

    @Id
    public String id;

    @Field("nombre_categoria")
    public String nombreCategoria;

    public Categoria(String nombre){
        this.nombreCategoria = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre_categoria() {
        return nombreCategoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombreCategoria = nombre_categoria;
    }
}


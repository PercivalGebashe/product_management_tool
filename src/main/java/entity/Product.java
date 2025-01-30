package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Blob;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    private String title;
    private int quantity;
    private int size;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private Blob image;
     public Product(){
     }

    // Getters and Setters
    public String getId() { return id.toString(); }
    public void setId(String id) { this.id = UUID.fromString(id); }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    public Blob getImage() { return image; }
    public void setImage(Blob image) { this.image = image; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", size=" + size +
                ", image=" + image +
                '}';
    }
}

package category.portfolio;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String messages;

    private String fileName;

    @Lob
    private byte[] data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", messages='" + messages + '\'' +
                ", fileName='" + fileName + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}

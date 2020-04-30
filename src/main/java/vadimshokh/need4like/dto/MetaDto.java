package vadimshokh.need4like.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetaDto {
    private String title;
    private String description;
    private String cover;


    public MetaDto(String title, String description, String cover) {
        this.title = title;
        this.description = description;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCover() {
        return cover;
    }
}
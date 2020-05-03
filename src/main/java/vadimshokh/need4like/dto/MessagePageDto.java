package vadimshokh.need4like.dto;

import com.fasterxml.jackson.annotation.JsonView;
import vadimshokh.need4like.domain.Message;
import vadimshokh.need4like.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonView(Views.FullMessage.class)
public class MessagePageDto {
    private List<Message> messages;
    private int currentPage;
    private int totalPages;
}

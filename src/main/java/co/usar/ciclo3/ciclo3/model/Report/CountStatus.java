package co.usar.ciclo3.ciclo3.model.Report;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CountStatus {
    private Long completed;
    private Long cancelled;

    public CountStatus(long size, long size1) {
    }
}
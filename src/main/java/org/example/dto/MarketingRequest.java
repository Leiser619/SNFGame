package org.example.dto;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class MarketingRequest {
    @NonNull
    @NotEmpty
    private String name;
    @NonNull
    @NotEmpty
    private String place;
    @NonNull
    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = { "M-d-yy", "dd.MM.yyyy" })
    private String date;
//    @NonNull
//    @OneToMany
//    private List<Artist> artists;
    @NonNull
    @NotEmpty
    private String description;
    @NonNull
    @NotEmpty
    private String promoter;

    @NonNull
    private int price;
}

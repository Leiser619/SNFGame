package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RestoreTicket {
    @NonNull
    @NotEmpty
    private final String mail;
    @NonNull
    @NotEmpty
    private final Long idEvent;
}

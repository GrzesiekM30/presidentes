package com.presidents.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class President {

    private Long id;
    private String name;
    private String surname;
    private Timestamp termFrom;
    private Timestamp termTo;
    private String politicalParty;
}

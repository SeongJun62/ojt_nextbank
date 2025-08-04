package com.ojtbank.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="acc_mst")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    @Id
    @Column(name="acc_no")
    private String acc_no;

    private long amt;

    private String cus_no;

    @Column(name="createdAt")
    private LocalDateTime createdAt;
}

package com.obligato.mvc.entity;


import lombok.*;

import java.time.LocalDateTime;

/*
CREATE TABLE application
(
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    performance_id INT,
    user_id        INT,
    message        TEXT,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (performance_id) REFERENCES Performance (performance_id),
    FOREIGN KEY (user_id) REFERENCES User (user_id)
);
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {
    private int applicationId;
    private int performanceId;
    private int userId;
    private String message;
    private LocalDateTime createdAt;

}

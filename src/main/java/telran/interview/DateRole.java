package telran.interview;

import java.time.LocalDate;

public record DateRole(LocalDate date, String role) {
public LocalDate getDate(){
    return date;
}
public String getRole(){
    return role;
}
}

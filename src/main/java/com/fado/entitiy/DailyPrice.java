package com.fado.entitiy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "daily_price")
public class DailyPrice {

    @Id
    String code;
    Date date;
    long open;
    long high;
    long low;
    long close;
    long diff;
    long volume;

    public DailyPrice(String code, Date date, long open, long high, long low, long close, long diff, long volume) {
        this.code = code;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.diff = diff;
        this.volume = volume;
    }
}

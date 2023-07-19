package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;
import lombok.ToString;
import org.w3c.dom.css.CSSStyleRule;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Location {
     String name;
     String region;
     String country;
     String tz_id;
     String localtime;

}

package org.openrap.jozijugjaxrs2.domain;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Autogenerate Getters , Setters and other horrible boiler plate
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class RaceBean {
    Long raceId;
    String name;
}

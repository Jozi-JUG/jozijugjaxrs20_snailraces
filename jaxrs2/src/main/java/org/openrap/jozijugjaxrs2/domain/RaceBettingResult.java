
package org.openrap.jozijugjaxrs2.domain;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@NoArgsConstructor
public class RaceBettingResult {
    /**
     * Constructor for an success condition
     * @param errorMessage
     * @param forRace 
     */
    public RaceBettingResult(RaceBean forRace) {
        this.forRace = forRace;
        this.success = true;
    }

    /**
     * Constructor for an error condition
     * @param errorMessage
     * @param forRace 
     */
    public RaceBettingResult(String errorMessage, RaceBean forRace) {
        this.errorMessage = errorMessage;
        this.forRace = forRace;
        this.success = false;
    }
    
    private boolean success;
    private String errorMessage;
    private RaceBean forRace;
}

package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Actual
{
    private String quantity;

    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    public String getQuantity(){
        return this.quantity;
    }
    
    
}
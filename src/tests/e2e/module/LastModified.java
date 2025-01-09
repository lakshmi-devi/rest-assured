package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class LastModified
{
    private By by;

    private String at;

    public void setBy(By by){
        this.by = by;
    }
    public By getBy(){
        return this.by;
    }
    public void setAt(String at){
        this.at = at;
    }
    public String getAt(){
        return this.at;
    }
    
   
}
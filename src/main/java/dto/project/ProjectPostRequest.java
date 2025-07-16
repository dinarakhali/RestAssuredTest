package dto.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.common.Leader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectPostRequest {
    private String name;
    private String shortName;
    private Leader leader;
    private String description;
}
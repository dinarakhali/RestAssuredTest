package dto.issue;

import dto.common.Leader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssuePostRequest {
    private Leader project;
    private String summary;
    private String description;
    private List<CustomFieldRequest> customFields;
}
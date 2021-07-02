package com.Headot.Redatores.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Post {

    public String id;
    public String userId;
    public String title;
    public String body;

}

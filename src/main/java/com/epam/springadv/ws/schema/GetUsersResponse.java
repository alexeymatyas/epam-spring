package com.epam.springadv.ws.schema;

import com.epam.springadv.model.entities.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Alexey on 30.10.2016.
 */
@XmlRootElement
public class GetUsersResponse {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

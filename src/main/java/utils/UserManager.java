package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import usermodel.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class UserManager {
    protected static ObjectMapper mapper;
    protected static InputStream inputStream;
    protected static TypeReference<List<User>> typeReference;
    protected static List<User> users;

    static {
        try {
            mapper = new XmlMapper();
            inputStream = new FileInputStream(new File("src/main/resources/users.xml"));
            typeReference = new TypeReference<List<User>>() {};
            users = mapper.readValue(inputStream, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(int index) {
        return users.get(index);
    }
}


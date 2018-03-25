package hello;
import hello.Person;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;


@RestController

public class Example {

	@Autowired
    	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	List<Person> home() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));

	}

}

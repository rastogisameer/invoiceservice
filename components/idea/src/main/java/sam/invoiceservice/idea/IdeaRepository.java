package sam.invoiceservice.idea;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class IdeaRepository {

    private JdbcTemplate jdbcTemplate;

    public IdeaRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long create(IdeaInvoice inv){

        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {

            PreparedStatement ps = con.prepareStatement(
                    "insert into invoices (payor, amount) value (?,?)", Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, inv.getPayorName());
            ps.setDouble(2, inv.getOriginalAmount());

            return ps;
        }, key);

        long id = key.getKey().longValue();

    }
    public IdeaInvoice read(long id){
        return new IdeaInvoice();
    }
    public IdeaInvoice update(long id, IdeaInvoice inv){

        return new IdeaInvoice();
    }
}

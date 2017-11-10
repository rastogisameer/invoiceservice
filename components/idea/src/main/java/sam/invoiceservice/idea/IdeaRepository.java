package sam.invoiceservice.idea;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

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
                    "insert into invoices (payorName, originalAmount) values (?,?)", Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, inv.getPayorName());
            ps.setDouble(2, inv.getOriginalAmount());

            return ps;
        }, key);

        long id = key.getKey().longValue();

        return id;

    }
    public List<IdeaInvoice> read(long id){

        return jdbcTemplate.query(
                "select invoiceId, payorName, originalAmount from invoices where invoiceId = ?", rowMapper, id
        );
    }
    public int update(long id, IdeaInvoice inv){

        return jdbcTemplate.update("update invoices set payorName = ?, originalAmount = ? where invoiceId = ?",
                inv.getPayorName(),
                inv.getOriginalAmount(),
                id);

    }
    public List<IdeaInvoice> readAll(){
        return jdbcTemplate.query(
                "select invoiceId, payorName, originalAmount from invoices where invoiceId = ?", rowMapper
        );
    }
    private RowMapper<IdeaInvoice> rowMapper = (rs, num) -> {
        IdeaInvoice inv = new IdeaInvoice(rs.getLong("invoiceId"), rs.getDouble("originalAmount"), rs.getString("payorName"));
        return inv;
     };
}

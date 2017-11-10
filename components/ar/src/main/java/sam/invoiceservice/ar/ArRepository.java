package sam.invoiceservice.ar;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ArRepository {

    private JdbcTemplate jdbcTemplate;

    public ArRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long create(ArInvoice inv){

        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {

            PreparedStatement ps = con.prepareStatement(
                    "insert into invoices (payorName, paymentAmount) values (?,?)", Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, inv.getPayorName());
            ps.setDouble(2, inv.getPaymentAmount());

            return ps;
        }, key);

        long id = key.getKey().longValue();

        return id;

    }
    public List<ArInvoice> read(long id){

        return jdbcTemplate.query(
                "select invoiceId, payorName, paymentAmount from invoices where invoiceId = ?", rowMapper, id
        );
    }
    public int update(long id, ArInvoice inv){

        return jdbcTemplate.update("update invoices set payorName = ?, paymentAmount = ? where invoiceId = ?",
                inv.getPayorName(),
                inv.getPaymentAmount(),
                id);

    }
    public List<ArInvoice> readAll(){
        return jdbcTemplate.query(
                "select invoiceId, payorName, paymentAmount from invoices where invoiceId = ?", rowMapper
        );
    }
    private RowMapper<ArInvoice> rowMapper = (rs, num) -> {
        ArInvoice inv = new ArInvoice(rs.getLong("invoiceId"), rs.getDouble("paymentAmount"), rs.getString("payorName"));
        return inv;
     };
}

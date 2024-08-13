package testastra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

public class TestAstra {

	public static void main(String[] args) {

		String username = System.getenv("CLIENT_ID");
		String password = System.getenv("SECRET");
		String secureConnectBundlePath = System.getenv("SECURE_CONNECT_BUNDLE");
		
        try (CqlSession session = CqlSession.builder()
                // make sure you change the path to the secure connect bundle below
                .withCloudSecureConnectBundle(Paths.get(secureConnectBundlePath))
                .withAuthCredentials(username,password)
                .withKeyspace("system")
                .build()) {

                    // For the sake of example, run a simple query and print the results
                    ResultSet rs = session.execute("select release_version from system.local");
                    Row row = rs.one();
                    System.out.println(row.getString(0));

                    ResultSet rs2 = session.execute("select now() from system.local");
                    Row row2 = rs2.one();
                    System.out.println(row2.getUuid(0));

                    ResultSet rs3 = session.execute("SELECT toUnixTimestamp(now()) FROM system.local;");
                    Row row3 = rs3.one();
                    System.out.println(row3.getLong(0));

        	}
        }
}

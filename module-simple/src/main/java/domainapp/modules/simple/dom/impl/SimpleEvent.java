package domainapp.modules.simple.dom.impl;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import java.time.LocalDateTime;
import java.util.TreeSet;

@javax.jdo.annotations.PersistenceCapable(identityType= IdentityType.DATASTORE, schema = "simple",table="simple_event")
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="id")
@javax.jdo.annotations.Queries({
		@javax.jdo.annotations.Query(
				name="queryBySimpleObject",
				value = "SELECT FROM domainapp.modules.simple.dom.impl.SimpleEvent " +
						"WHERE simpleObject == :simpleObject"
		)
})
@DomainObject(
		objectType = "simple.event"
)
@DomainObjectLayout()
@lombok.Getter @lombok.Setter
@lombok.RequiredArgsConstructor
public class SimpleEvent {
	@javax.jdo.annotations.Column(allowsNull = "false",name = "simple_id")
	@lombok.NonNull
	@Property() // editing disabled by default, see isis.properties
	private SimpleObject simpleObject;

	@javax.jdo.annotations.Column(allowsNull = "false")
	@lombok.NonNull
	@Property() // editing disabled by default, see isis.properties
	private long time;


}

package repository;

import com.property.feedback.repository.PropertyRepo;
import com.property.feedback.repository.models.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nehaojha on 08/11/16.
 */
public class PropertyRepoTest {

    private PropertyRepo propertyRepo;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context-test.xml");
        propertyRepo = context.getBean(PropertyRepo.class);
    }

    @Test
    public void findNearByProperties() throws Exception {
        setUpDB();
        List<Property> nearByProperties = propertyRepo.findNearByProperties(28.512783, 77.036893);//columbia asia palam vihar gurgaon
        List<Property> expectedProperties = getExpectedList();
        Assert.assertNotNull(nearByProperties);
        Assert.assertTrue(!nearByProperties.isEmpty());
        Assert.assertTrue(expectedProperties.equals(nearByProperties));
        nearByProperties.stream().forEachOrdered(System.out::println);
        expectedProperties.stream().forEachOrdered(System.out::println);

        cleanDB();
    }

    private void setUpDB() {
        propertyRepo.save(new Property("jmd megapolis sector 48 grugaon", 28.419657, 77.038186));
        propertyRepo.save(new Property("Ambience mall gurgaon", 28.504865, 77.094588));
        propertyRepo.save(new Property("445, sector 22 B gurgaon", 28.510708, 77.066766));
        propertyRepo.save(new Property("626, sector 21 pocket e gurgaon", 28.513393, 77.072276));
        propertyRepo.save(new Property("hewo 2 apartment, jalwayu towers road, sector 56 gurgaon", 28.430068, 77.098305));
    }

    private void cleanDB() {
        propertyRepo.deleteAll();
    }

    public List<Property> getExpectedList() {
        List<Property> properties = new ArrayList<>();
        properties.add(new Property("445, sector 22 B gurgaon", 28.510708, 77.066766));
        properties.add(new Property("626, sector 21 pocket e gurgaon", 28.513393, 77.072276));
        properties.add(new Property("Ambience mall gurgaon", 28.504865, 77.094588));
        properties.add(new Property("jmd megapolis sector 48 grugaon", 28.419657, 77.038186));
        properties.add(new Property("hewo 2 apartment, jalwayu towers road, sector 56 gurgaon", 28.430068, 77.098305));
        return properties;
    }
}
package plgym.util;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Manages updates to a user instance.
 * @author <a href="https://stackoverflow.com/users/5668795/alexander-petrov">Alexander Petrov</a>
 * @see <a href="https://stackoverflow.com/questions/52424734/basic-put-update-on-spring-boot/52425602">Stack Overflow</a>
 */
public class Persistence
{
    /**
     * Updates 'dbObject' with the values in 'partialUpdateObject' that are not null.
     * @param dbObject Object to be updated.
     * @param partialUpdateObject Object with partial updates to be used.
     * @return Updated dbObject.
     */
    public static Object partialUpdate(Object dbObject, Object partialUpdateObject)
    {
        String[] ignoredProperties = getNullPropertyNames(partialUpdateObject);
        BeanUtils.copyProperties(partialUpdateObject, dbObject, ignoredProperties);
        return dbObject;
    }
    
    /**
     * Gets names of a class' properties of which the values in 'object' are null.
     * @param object Object from which null property names are needed.
     * @return Array containing names of desired properties.
     */
    private static String[] getNullPropertyNames(Object object)
    {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(object);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}


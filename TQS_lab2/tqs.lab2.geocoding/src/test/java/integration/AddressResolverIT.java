package integration;

import connection.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolver;
import java.util.Optional;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddressResolverIT {


    @BeforeEach
    public void init(){
    }

    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {

        //todo
        TqsBasicHttpClient client = new TqsBasicHttpClient();

        AddressResolver resolver = new AddressResolver(client);
                
        
        // repeat the same tests conditions from AddressResolverTest, without mocks
        Optional<Address> result = resolver.findAddressForLocation(40.640661, -8.656688);
        Address test = result.get();

        assertEquals(new Address("Cais do Alboi", "Glória e Vera Cruz", "Centro", "3800-246", null), test);

    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddrress() throws IOException, URISyntaxException, ParseException {

        //todo
        // repeat the same tests conditions from AddressResolverTest, without mocks
        TqsBasicHttpClient client = new TqsBasicHttpClient();

        final AddressResolver resolver = new AddressResolver(client);

        assertThrows(IllegalArgumentException.class, () -> {resolver.findAddressForLocation(-300.0, -810.0);});        
    }

}

package com.selfeval.eurder.api.order;

import com.selfeval.eurder.api.order.dto.TotalPriceOrderDTO;
import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.item.ItemRepository;
import com.selfeval.eurder.domain.shared.valueclasses.Price;
import com.selfeval.eurder.domain.user.UserRepository;
import com.selfeval.eurder.domain.user.baseclasses.*;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@DisplayName("OrderController EndToEnd Testing")
@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext
class OrderControllerTest {
    private Item item1;
    private Item item2;
    private User user;
    private final Map<String, String> orderInputMap = new HashMap<>();
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    private TotalPriceOrderDTO priceOrderDTO;
    @LocalServerPort
    private int port;
    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        item1 = new Item(
                "Cola",
                "Boisson",
                new Price(1.0, "Eur"),
                100);
        item2 = new Item(
                "Ice Tea",
                "Boisson",
                new Price(2.0, "Eur"),
                100);
        itemRepository.addItem(item1);
        itemRepository.addItem(item2);
        user = new User(
                new Name("Max", "Jean"),
                new Contact(new Address(
                        "BossTown",
                        "KingsLand",
                        "10",
                        "Rue du Succes",
                        10),
                        "0458975645",
                        "pascalis.leboss@gmail.com"),
                Role.CUSTOMER);
        userRepository.addUser(user);
        orderInputMap.put(String.valueOf(item1.getId()),"5");
        orderInputMap.put(String.valueOf(item2.getId()),"5");
    }

    @Test
    void createOrder_thenTotalPriceIsReturned() {
        priceOrderDTO = RestAssured
                .given()
                .body(orderInputMap)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/orders/" + user.getId() +"/create")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(TotalPriceOrderDTO.class);
        assertNotNull(priceOrderDTO);
        assertEquals(15.0, priceOrderDTO.getPrice().getAmount());
    }
}
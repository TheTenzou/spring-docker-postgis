INSERT INTO restaurant (restaurant_name, restaurant_location, restaurant_lat, restaurant_lon) VALUES ('test', 'Helsinki', 123, 456);

INSERT INTO menu (restaurant_id, menu_date, menu_title, menu_text) VALUES (1, CURRENT_DATE(), 'Soups', 'Hello, World!');
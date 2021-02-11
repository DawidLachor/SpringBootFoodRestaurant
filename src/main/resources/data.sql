insert into item(price, name, short_description, description) VALUES
(22.50, 'Pizza Margherita', 'Włoska pizza na cienkim cieście z serem i sosem pomidorowym',
 'Pizza Margherita to klasyka włoskiej kuchni. W naszym wydaniu serwujemy pizzę na cienkim cieście z ' ||
 'ręcznie przygotowanym sosem pomidorowym i oryginalnym serem mozarella'),
(25.99, 'Pizza Capriciosa', 'Pizza na cienkim cieście z serem, sosem pomidorowym i pieczarkami',
 'Pizza Capriciosa to po Marghericie najpopularniejsza wersja tej smacznej włoskiej potrawy. Oprócz naszego ' ||
 'domowego sosu pomidorowego i oryginalnej włoskiej mozarelli znajdziesz tutaj także pieczarki i wyśmienitą sznkę.'),
(32.99, 'Spaghetti Bolognese', 'Robiona na miejscu pasta z sosem pomidorowym i wołowiną',
 'Idealna propozycja dla każdego miłośnika pasty. Spaghetti bolognese w naszym wykonaniu to ręcznie przygotowany ' ||
 'makaron z sosem pomidorowym oraz wysokiej jakości wołowiną. Do przygotowania sosu wykorzystujemy pomidory z ' ||
 'lokalnych upraw oraz świeże zioła.'),
(18.99, 'Panna Cotta', 'Klasyczny włoski deser o smaku śmietankowym z polewą z truskawek',
 'Masz ochodę na coś słodkiego? Ta propozycja to nasza interpretacja jednego z najbardziej rozpoznawalnych włoskich' ||
 'deserów. Przygotowujemy go ze śmietanki BIO, świeżego mleka i prawdziwej wanilii. Na życzenie deser podajemy ' ||
 'w alternatywnej wersji z sosem czekoladowym.');
insert into client_order(address, telephone, status) VALUES
('Zakrzewskiego 23/5, 50-225 Wrocław', '888777666', 'NEW'),
('Kościuszki 13, 52-316 Wrocław', '767454989', 'NEW'),
('Krakowska 88/16, 51-515 Wrocław', '666234123', 'IN_PROGRESS'),
('Centralna 8/12, 55-100 Wrocław', '598787999', 'IN_PROGRESS'),
('Dworcowa 33, 51-200 Wrocław', '600700900', 'COMPLETE'),
('Krucza 66/4, 53-300 Wrocław', '696787898', 'COMPLETE'),
('Zakrzewskiego 23/5, 50-225 Wrocław', '888777666', 'NEW');
insert into order_item (order_id, item_id) values
(1, 1),
(1, 2),
(1, 3),
(2, 3),
(2, 4),
(3, 1),
(3, 1),
(3, 1),
(4, 1),
(4, 2),
(5, 3),
(5, 3),
(5, 4),
(6, 4),
(6, 4),
(7, 2);

USE theatrebooking;

INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Queen', 'Queen are here to rock your socks off!', '120', 'English', 'Concert', '1', '10.00', '20.00');
INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Le Figaro', 'Mozarts back with a brand new track!', '180', 'Italian', 'Opera', '1',  '6.00', '12.00');
INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Les Miserable', 'The French are back with a revolution. King Louis is a bit worried', '120', 'English', 'Musical', '0', '9.00', '14.00');
INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Shakespeare: To be, or not be', 'A new take on the Shakespeare play Hamlet', '90', 'English', 'Theatre', '0', '5.00', '10.00');
INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Bugsy Malone', 'The kids are back with swing', '150', 'English', 'Musical', '1', '10.00', '7.00');
INSERT INTO showProduction (showName, showDescription, duration, language, typeID, liveAccompaniment, circlePrice, stallPrice) VALUES ('Adele', 'Latest hits from the album 104', '120', 'English', 'Concert', '1', '20.00', '30.00');

INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-10', '19:30:00', '120', '80', '1');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-12', '14:00:00', '120', '80', '2');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-12', '19:30:00', '120', '80', '2');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-18', '19:30:00', '120', '80', '3');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-19', '19:30:00', '120', '80', '3');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-10-20', '19:30:00', '120', '80', '3');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-11-06', '17:30:00', '120', '80', '4');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-12-04', '17:30:00', '120', '80', '4');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-12-10', '18:00:00', '120', '80', '5');
INSERT INTO performance (showDate, showStartTime, totalAvailibilityStalls, totalAvailibilityCircle, showProductionID) VALUES ('2022-12-14', '20:00:00', '120', '80', '6');

INSERT INTO musicPerformer (name, showProductionID) VALUES ('Freddie Mercury', '1');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Brian May', '1');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('John Deacon', '1');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Roger Taylor', '1');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Wolfgang Amadeus Mozart', '2');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Julia Steiner', '2');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('New York Philharmonic Orchestra', '3');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Esa Pekka Salonen', '3');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('James Gall', '5');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Ed Sheeran', '5');
INSERT INTO musicPerformer (name, showProductionID) VALUES ('Adele', '6');

INSERT INTO regularPerformer (name, showProductionID) VALUES ('Ryan Gosling', '3');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Emma Stone', '3');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Harry Styles', '3');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Vanessa Hudgens', '3');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Danny DeVito', '4');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Benedict Cumberbatch', '4');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Emma Thompson', '4');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Joanna Lum', '5');
INSERT INTO regularPerformer (name, showProductionID) VALUES ('Dara OBrian', '5');
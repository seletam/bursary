INSERT INTO study(name)VALUES("ELECTRONIC ENGINEERING");
INSERT INTO study(name)VALUES("CIVIL ENGINEERING");
INSERT INTO study(name)VALUES("ELECTRONIC ENGINEERING");
INSERT INTO study(name)VALUES("COMPUTER ENGINEERING");
INSERT INTO study(name)VALUES("COMMERCIAL");

INSERT INTO applicant(email,first_name,last_name,middle_name, gender,study_id,birth_date)VALUES("seletam@gmail.com","Seleta","Mootwane","Mcdonald",0,1,"1991-12-29");
INSERT INTO applicant(email,first_name,last_name,middle_name, gender,study_id,birth_date)VALUES("bontlewaphindi@gmail.com","Phindile","Hlekiso","Charlotte",1,2,"1994-05-15");
INSERT INTO applicant(email,first_name,last_name,middle_name, gender,study_id,birth_date)VALUES("PrinceMasedi@csir.co.za","Prince","Masedi","Ngwanamotswana",0,1,"1988-06-00");
INSERT INTO applicant(email,first_name,last_name,middle_name, gender,study_id,birth_date)VALUES("VInabathini@csir.co.za","Venkata","Inabathini","Venkata",0,3,"1973-00-00");

--SELETA
INSERT INTO qualification(institution,name, qualification_status)VALUES("TUT","IT",0);
INSERT INTO qualification(institution,name, qualification_status)VALUES("UNISA","BA",1);
INSERT INTO qualification(institution,name, qualification_status)VALUES("UJ","PDG",1);
--PHINDILE
INSERT INTO qualification(institution,name,qualification_status)VALUES("VUT","BSC IT",0);
INSERT INTO qualification(institution,name,qualification_status)VALUES("TUT","BTECH IT",0);
INSERT INTO qualification(institution,name,qualification_status)VALUES("UI","JAVA",0);

--SELETA
INSERT INTO address(street,city,country,state_or_province,address_type)VALUES("Bochum", "Polokwane", "SA", 0, 0);
INSERT INTO address(street,city,country,state_or_province,address_type)VALUES("Box 438", "Polokwane", "SA", 0, 1);

--PHINDILE
INSERT INTO address(street,city,country,state_or_province,address_type)VALUES("SASOL", "SASOL", "SA", 7, 0);

--SELETA
INSERT INTO applicant_address(applicant_id,address_id)VALUES(1,1);
INSERT INTO applicant_address(applicant_id,address_id)VALUES(1,2);
INSERT INTO applicant_address(applicant_id,address_id)VALUES(2,3);

--SELETA
INSERT INTO applicant_qualification(applicant_id,qualification_id)VALUES(1,1);
INSERT INTO applicant_qualification(applicant_id,qualification_id)VALUES(1,2);
INSERT INTO applicant_qualification(applicant_id,qualification_id)VALUES(1,3);

--PHINDILE
INSERT INTO applicant_qualification(applicant_id,qualification_id)VALUES(2,4);

--SELETA
INSERT INTO subject(name,score)VALUES("IT MANAGEMENT", 85);
INSERT INTO subject(name,score)VALUES("MANAGEMENT", 58);
INSERT INTO subject(name,score)VALUES("PROJECT MANAGEMENT", 63);
INSERT INTO subject(name,score)VALUES("SOFTWARE DEVELOPMENT", 60);
INSERT INTO subject(name,score)VALUES("DECISON SUPPORT SYSTEMS", 81);
INSERT INTO subject(name,score)VALUES("BUSINESS INTELLIGENCE", 71);
INSERT INTO subject(name,score)VALUES("BUSINESS ORGANISATIONS", 61);
INSERT INTO subject(name,score)VALUES("BUSINESS COMMUNICATIONS", 53);

--PHINDILE
INSERT INTO subject(name,score)VALUES("STATISTICS I", 85);
INSERT INTO subject(name,score)VALUES("STATISTICS II", 58);
INSERT INTO subject(name,score)VALUES("PROGRAMMING I", 63);
INSERT INTO subject(name,score)VALUES("PROGRAMMING I", 60);
INSERT INTO subject(name,score)VALUES("DATABASE DESIGN III", 81);
INSERT INTO subject(name,score)VALUES("BUSINESS INTELLIGENCE II", 51);
INSERT INTO subject(name,score)VALUES("METHOLODOLOGIES II", 61);
INSERT INTO subject(name,score)VALUES("COMMUNICATIONS", 73);

--SELETA
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(1, 1);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(1, 2);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(1, 3);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(1, 4);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(2, 5);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(2, 6);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(2, 8);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(1, 7);

--PHINDILE
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(4, 9);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(4, 10);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(4, 11);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(4, 12);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(4, 13);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(4, 14);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(4, 15);
INSERT INTO qualification_subjects(qualification_id,subjects_id)VALUES(4, 16);


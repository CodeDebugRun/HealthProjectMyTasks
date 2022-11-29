@Settings
Feature: US006 Kayit bilgilerinin ayni oldugunu ve guncellenebildigini teyit et


  Scenario Outline: US006 TC01 settings bilgilerinin kaydedilen ile ayni oldugunu teyit et
    Given EA kullanici "https://medunna.com/" sayfasina gider
    When EA login olmak icin signin e tiklar
    And EA username icin "<userName>" kullanici adini gonderir
    And EA password icin "<password>" parolasini gonderir
    And EA signine tiklar
    Then EA username ile giris yaptigini dogrular
    Then EA settings linkini tiklar
    Then EA FirstName in dogru "<firstName>" oldugunu dogrular
    Then EA LastName in dogru "<LastName>" oldugunu dogrular
    Then EA Email in dogru "<eMail>" oldugunu dogrular
    Then EA sign out icin Account menuye tiklar



    Examples:
      | userName     | password   | firstName | LastName | eMail         |
      | DoktorAlican | Doktor0003 | Doktor    | Alican   | doktoralican  |

@SettingsExcel
Feature: US006 Kayit bilgilerinin ayni oldugunu ve guncellenebildigini Excelden teyit et

  @VerifyInfo
  Scenario: US006 TC01 settings bilgilerinin kaydedilen ile ayni oldugunu Excelden teyit et

    Given EA kullanici "https://medunna.com/" sayfasina gider
    When EA login olmak icin signin e tiklar
    And EA username icin "<userName>" kullanici adini excelden gonderir
    And EA password icin "<password>" parolasini excelden gonderir
    And EA signine tiklar
    Then EA username ile giris yaptigini dogrular
    Then EA settings linkini tiklar
    Then EA FirstName in dogru "<firstName>" oldugunu excelden dogrular
    Then EA LastName in dogru "<LastName>" oldugunu excelden dogrular
    Then EA Email in dogru "<eMail>" oldugunu excelden dogrular
    Then EA sign out icin Account menuye tiklar

  @UpdateInfo
  Scenario: US006 TC01 settings bilgilerinin guncellnebelildigini Excelden teyit et

    Given EA kullanici "https://medunna.com/" sayfasina gider
    When EA login olmak icin signin e tiklar
    And EA username icin "<userName>" kullanici adini excelden gonderir
    And EA password icin "<password>" parolasini excelden gonderir
    And EA signine tiklar
    Then EA username ile giris yaptigini dogrular
    Then EA settings linkini tiklar
    Then EA FirstName "<firstName>" gunceller
    Then EA LastName "<LastName>" gunceller
    Then EA Email in "<eMail>" gunceller
    Then EA save butonuna tiklar
    Then EA sign out icin Account menuye tiklar
    Then EA sign in again butonuna tiklar
    And EA username icin "<userName>" kullanici adini excelden gonderir
    And EA password icin "<password>" parolasini excelden gonderir
    And EA signine tiklar
    Then EA settings linkini tiklar
    Then EA FirstName in guncel "<firstName>" oldugunu excelden dogrular
    Then EA LastName in guncel "<LastName>" oldugunu excelden dogrular
    Then EA Email in guncel "<eMail>" oldugunu excelden dogrular

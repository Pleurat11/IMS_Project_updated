Feature: As a user I want to create multiple components at once
  @componentAddsss
  Scenario Outline: User creates multiple components
    Given I am on the dashboard page
    When I click on catalogs module
    And I click on components module
    And I click on the new button
    And I send "<Component name>" to component field
    And I select the first customer from the dropdown
    And I send "<PartNr>" to part number field
    And I send "<Vendor>" to revision nr field
    And I click on the Save button
    Then A new component should be created successfully
    Examples:
    |Component name|Vendor|PartNr|
#    |ASM-00119|Wright Engineered Plastics|
#    |ASM-00120|Wright Engineered Plastics|
#    |ASM-00121|Wright Engineered Plastics|
#    |ASM-00124|Wright Engineered Plastics|
#    |PRT-1    |Sidco|
#    |PRT-2    |Sidco|
#    |PRT-3    |Inland Group|
#    |PRT-00166|Inland Group|
#    |PRT-00238|Wright Engineered Plastics|
#    |PRT-00346|RenyMed|
#    |PRT-00348|RenyMed |
#    |ASM-00396|RenyMed |ASM-00369|
#    |ASM-00412|Oliver | ASM-00412|
#    |PRT-00426|Royal Paper Box Company|
#    |PRT-00427|Royal Paper Box Company|
#    |PRT-00469|RenyMed|
#    |PRT-00524|Prent|
#    |PRT-00525|Prent|
#    |PRT-00526|Prent|
#    |PRT-00257|Kelly Spicers Packaging|
#    |PRT-00532|Kelly Spicers Packaging|
#    |PRT-00566|Inland Group|
#    |PRT-00605|Kelly Spicers Packaging|
#    |PRT-00662|Sidco|

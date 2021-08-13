# My Personal Project: Vaccine Passport for CPSC 210 (Summer Term 2)

#CS ID: z3b3b

## Phase 1 - Term 2 - Task 2 - Project Information

*What will this application do?*
- It will keep records of which *vaccines* you have received (type, date, booster shot)
- It will allow you to organize vaccine *record profiles* for different people in your family
- (*Optional*) Provide notice if a booster shot is required
- (*Optional* = Secondary design/implementation goal if primary code is successfully completed)


**Who will use it?**
- Individuals who want to *digitally* keep track of their vaccination records
- Parents who need to keep track of their child's immunization records
- Doctors could use it to keep track of their patients' immunizations

**Why is this project of interest to you?**
- As a parent, I was surprised there was no consistent digital method to keep track of family vaccinations
- Traditional methods of vaccine records, such as papers, are easily lost and inconsistent across healthcare regions
- The *COVID-19 pandemic* has brought to the global forefront of the importance of accurate vaccine records


## Phase 1 - Task 3 - User Stories


**In the context of a vaccine passport application:**
- As a user, I want to be able to create a new vaccine record profile 
- As a user, I want to be able to add a vaccine record to a vaccine record profile
- As a user, I want to be able to include details to a vaccination record: vaccine type, date received
- As a user, I want to be able to view the list of vaccinations in a vaccination profile
- As a user, I want to be able to select a vaccine record profile and view the list of vaccines
- As a user, I want to be able to create additional vaccination profiles for other individuals (e.g. family members)
- As a user, I want to be able to view a list of vaccination profiles
- As a user, I want to be able to delete a vaccine record profile
- As a user, I want to be able to edit a vaccine record 
- As a user, I want to be able to edit a vaccine record profile (e.g. Name of profile)
- As a user, I want to check if any vaccines in my profile require a booster shot 

## Phase 2
- As a user, I want to be able to save my vaccine profile to file
- As a user, I want to able to load my vaccine profile from file

## Phase 3

**Due to time constraints, I needed to narrow the scope of my user stories**

- As a user, I want to add listed vaccinations to my vaccine profile
- As a user, I want to remove listed vaccinations from my vaccine profile
- As a user, I want to only show vaccinations that require a booster shot with a confirmation sound
- As a user, I want to be able to save my vaccine profile to file
- As a user, I want to able to load my vaccine profile from file
- As a user, I want to see all vaccines in my profile


## Phase 4: Task 2

Option: Make use of bi-directional association

- I used a bi-direction association between the GUI class and VaccineApp
- I had used this relationship to try to keep the graphical interface methods separate from the vaccine app methods
- Initially, I thought if I could keep the same functionalities from the console UI (Phase 2) then I would only...
... need to create a GUI class - leaving the VaccineApp class untouched
- However, as I started coding, I realized that the VaccineApp class needed new methods to pass along the processed info
- The GUI class add VaccineApp class are called to each other in the Main class establishing the initial relationship
- This lets me call on VaccineApp methods in the GUI class; and vice versa
- This helped me send information from one class to the other
- For example, I can process the latest list of vaccine in VaccineApp then send that information to the GUI class..
... so it can be turned into a list of strings and then inputted into JFrame text food. 


## Phase 4: Task 3

**Reflections**






## LMS Log

**24/01/2025**

- Initialized Repository.
- Created 2 directories (one for LMS app and one for LMS-Admin app)
- For each directory, there are all the utilities needed.
- Created common directories lib (for json file handling) and data (for storing JSON files)
- Each app consists of utilities following a controller and manager design.

**25/01/2025**
- properly configured modules and dependencies(lib and entities from shared).
- Initial Program flow outline: 
  + for both apps the flow goes: menu -> controller -> manager
  + Menu: display choices and returns the choice (String).
  + controller: takes in the choice as the argument and do action (call to managers if needed)
  + Manager: only handles data retrieval and writing. 
- began implementing and testing this design.

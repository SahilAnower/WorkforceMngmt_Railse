### 1. Link to your Public GitHub Repository
[https://github.com/SahilAnower/WorkforceMngmt_Railse/tree/dev]

> Bug 1: Already fixed with previous code

> Bug 2: Just added single filter for ```Cancelled``` Status

> Feature 1: For SmartDateView (```/fetch-by-date/v1```) feature, added a new field ```taskCreationTime``` in ```TaskManagement.java``` and while getting the tasks, checking their creationTime is within the given start and end time, in case task status is completed.

> Feature 2: For priority based getting of tasks, added ```/tasks/priority/{priority}``` get request and for update as well addition of field priority in the updateRequest which would be taken account into the TaskManagement object for update.

> Feature 3: For TaskHistory, added SpringAOP while saving of a task, to track CDC in case of new or existing, and thus has it's own repo, where ```taskId, timestamp``` uniquely identifies each tasklog.
> 
> In case of comments, ``/comment/{taskId}``` defines posting for a comment, and similarly has it's own service, repo, dto(Create/Update requests), and while getting of a single individual task, we ask both taskHistoryRepo and commentRepo to give their data in chronological order according to it's taskId

### 2. Link to your Video Demonstration
(Please ensure the link is publicly accessible)
[https://drive.google.com/file/d/1KYJJDVgi56nwY62bbYwVEWHpwdx53-bL/view?usp=sharing]
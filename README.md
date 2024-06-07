# Web calculator

Practice for Neoflex. This project was created by Domenika Poltapova, group 32919/2. Contact: nipoltapova@mail.ru.

## Overview

This web calculator can add and subtract integers. The results of the operations are stored in the database memory.

## API documentation

>API UI documentation - *address*/ui;
>API-docs - *address*/api-docs.

API has 5 functional endpoints:
- summation of integers (*address*/plus/{x value}/{y value}) - returns a JSON object with an expression as a string and the result as an integer or an error message;
![image](https://github.com/NiPoltapova/PracticeNeoflex/assets/120168189/b8ede776-125c-49e3-9e91-930ea5bf2e6f)
- provide all expressions with summation (*address*/plus) - returns a JSON object with a list of expression objects;
![image](https://github.com/NiPoltapova/PracticeNeoflex/assets/120168189/33f5bb8f-561a-4a11-88d8-d71baf28b526)
- subtracting integers (*address*/minus/{x}/{y}) - returns a JSON object with an expression as a string and the result as an integer or an error message;
![image](https://github.com/NiPoltapova/PracticeNeoflex/assets/120168189/ebaf1bcc-9601-40dd-b929-20ee70e6b273)
- provide all expressions with subtraction (*address*/minus) - returns a JSON object with a list of expression objects;
![image](https://github.com/NiPoltapova/PracticeNeoflex/assets/120168189/4ef1cb69-cea7-4cf9-b067-b16817a9609a)
- provide all expressions (*address*/all) - returns a JSON object with a list of expression objects.
![image](https://github.com/NiPoltapova/PracticeNeoflex/assets/120168189/7df4cb52-60f7-4a2e-a57e-e311d79cfb0a)

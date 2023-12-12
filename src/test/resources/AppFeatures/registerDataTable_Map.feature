Feature: User Registration

Scenario: User Registration with diffrent data
Given User is on Register page
When User enters following user details with columns
	|Name | Role | Email | Salary | Location |
	| vrushal | SDET | vrushal@gmail.com | 5900000 | Remote, India |
	| pradnya | Data Scientist | pradnya@gmail.com | 590000 | Pune, India |
Then User Registration Successfull
	
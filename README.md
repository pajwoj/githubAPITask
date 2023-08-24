# githubAPITask

An API that allows the user to check GitHub repositories for a given user.

# Usage 
After running the application, the API is available at /api?username=[USERNAME]

# Responses
The application responds in JSON format.

When given nonexistent user: 404 status code with "User not found." message.

When the request has an "Accept: application/xml" header: 406 status code with "Request does not produce XML." message.

When the request is correct: A JSON containing all GitHub repositories of input user (not forks), in this format:

- owner: GitHub username
- name: repository name
- branches: JSON Array containing all branches of current repository, the array contains the branch name and latest commit SHA

# Example usage + result

todo when no more rate limit:D
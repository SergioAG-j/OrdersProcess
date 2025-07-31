# Apprenticeship Report: Test Frameworks – Jest in `mbi.luna.integrations`

## Overview

- Uses **Jest** as the JavaScript testing framework
- Selected for:
  - Simplicity
  - Speed
  - Powerful mocking capabilities
- Suitable for:
  - Unit testing
  - Integration testing in **Node.js** applications

---

## How Jest Testing Works in This App

### Test Organization

- Test files located in the `tests/` directory
- Files use the `.test.js` suffix
- Each file targets a specific module or feature

### Test Structure

- Tests grouped using `describe` blocks
- Test cases defined using `it` or `test`

```js
describe('sendPatientMessage', () => {
  it('should send a correctly formatted HL7 payload', async () => {
    // test logic...
  });
});
```

### Mocking

- External dependencies are mocked using:

  - `jest.mock()`

  - Manual mock implementations

- Dependencies mocked include:

  - `Prisma`

  - `Axios`

  - `fetch`

- Purpose of mocking:

  - Isolate tests from real databases and APIs

  - Improve test reliability and execution speed

### Setup & Teardown

- Lifecycle hooks used:

  - `beforeEach` to set up test data

  - `afterEach` to clean up

- Consistency maintained using:

  - Seed files

  - Mock objects

### Assertions

- expect() function used to:

  - Check outputs

  - Validate error handling

  - Verify database state

### Error Handling

- Tests verify:

  - Proper error throwing

  - Correct handling of edge cases

  - Behavior with invalid data

### Coverage

- Test suite includes:

  - Core business logic

  - API integrations

  - Database operations

### Example Test Analysis

#### From payloadConstructor.test.js

- Mocks fetch before importing the module

- Confirms sendPatientMessage:

  - Sends a POST request

  - Includes correct payload, headers, and method

#### From jobs.test.js

- Mocks database and API calls

- Validates:

  - Job logic

  - Message limits

  - Patient message creation

- Uses hooks for:

  - Seeding test data

  - Cleaning up after tests

## Benefits of Jest

- Fast and parallel test execution

- Built-in mocking and assertion libraries

- Easy integration with CI/CD pipelines

- Detailed error and coverage reporting

## Conclusion

- Provides a reliable and maintainable testing environment

- Enables:

- Use of mocks

- Lifecycle hooks

- Clear assertions

- Supports code quality and confidence in behavior
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <!-- Bootstrap CSS -->
        <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
        <!-- External CSS -->
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container d-flex align-items-center justify-content-center vh-100">
            <div class="card shadow-sm p-4" style="width: 100%; max-width: 400px;">
                <form class="form-signin" method="post" action="/login">
                    <h2 class="text-center mb-4">Login</h2>

                    <!-- Email Input -->
                    <div class="form-group">
                        <label for="username">Email Address</label>
                        <input
                            type="email"
                            class="form-control"
                            id="username"
                            name="username"
                            placeholder="Enter your email"
                            required
                            autofocus
                            aria-label="Email Address">
                    </div>

                    <!-- Password Input -->
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input
                            type="password"
                            class="form-control"
                            id="password"
                            name="password"
                            placeholder="Enter your password"
                            required
                            aria-label="Password">
                    </div>

                    <!-- Remember Me Checkbox -->
                    <div class="form-group form-check">
                        <input
                            type="checkbox"
                            class="form-check-input"
                            id="rememberMe"
                            name="rememberMe">
                        <label class="form-check-label" for="rememberMe">Remember me</label>
                    </div>

                    <!-- Submit Button -->
                    <button
                        class="btn btn-primary btn-block"
                        type="submit">
                        Login
                    </button>
                </form>
            </div>
        </div>

        <!-- Bootstrap JS -->
        <script
          src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
          integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
          crossorigin="anonymous">
        </script>
        <script
          src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/js/bootstrap.min.js"
          integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
          crossorigin="anonymous">
        </script>
        <script src="js/script.js"></script>
    </body>
</html>

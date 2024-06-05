<div class="d-flex justify-content-center">
    <form class="form-horizontal p-5 bg-light" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2 my-2" for="name">Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="reg-name" placeholder="Enter a name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2 my-2" for="lname">Last Name:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="lname" name="reg-lastn" placeholder="Enter a last name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2 my-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="reg-email" placeholder="Enter email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2 my-2" for="pwd">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="pwd" name="reg-pss" placeholder="Enter password">
            </div>
        </div>
        <!-- <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox my-2">
                    <label><input type="checkbox"> Remember me</label>
                </div>
            </div>
        </div> -->

        <?php
        //Instances of non-static methods
        //$register = new FormsController();
        //$register->ctrRegister();
        
        //Instances of static methods
        $reg = FormsController::ctrRegister();
        if ($reg == "ok") {
            echo '
				<script>
                if (window.history.replaceState) {
                    window.history.replaceState(null, null, window.location.href);
                }
				</script>';
            echo '<div class="alert alert-success">User has been registered</div>';
        }
        if ($reg == "error") {
            echo '
            <script>
            if (window.history.replaceState) {
                window.history.replaceState(null, null, window.location.href);
            }
            </script>';
            echo '<div class="alert alert-danger">User has not been registered</div>';
        }

        ?>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10 my-2">
                <button type="submit" class="btn btn-primary">Send</button>
            </div>
        </div>
    </form>
</div>
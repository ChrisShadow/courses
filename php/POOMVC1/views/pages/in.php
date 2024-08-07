<div class="d-flex justify-content-center">
    <form class="form-horizontal p-5 bg-light" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2 my-2" for="email">Email:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="login-email" placeholder="Enter email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2 my-2" for="pwd">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="pwd" name="login-pwd" placeholder="Enter password">
            </div>
        </div>
        <?php
        //static: for using the object both in the controller and the view
        //no-static: for using the object only in the controller
        $login = new FormsController();
        $login->ctrLogin();
        ?>

        <div class="form-group">
            <!-- <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox my-2">
                    <label><input type="checkbox"> Remember me</label>
                </div>
            </div> -->
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10 my-2">
                <button type="submit" class="btn btn-primary">Send</button>
            </div>
        </div>
    </form>
</div>
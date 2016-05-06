<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

				<!-- Modal -->
				<div id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<div class="stuff" id="loginModal">
		<div class="modal-header">

			<h3>Kirjaudu sisään</h3>
		</div>
		<div class="modal-body">
			<div class="well">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#login" data-toggle="tab">Kirjaudu</a></li>
					<li><a href="#create" data-toggle="tab">Rekisteröidy</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane active in" id="login">
						
							<div class="form-group">
								<label for="exampleInputEmail1">Sähköposti</label> <input
									type="email" class="form-control" name="sahkoposti"
									placeholder="Sähköposti">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Salasana</label> <input
									type="password" class="form-control" name="salasana"
									placeholder="Salasana">
							</div>
							<button type="submit" class="btn btn-default" name="action"
								value="Kirjaudu">Kirjaudu</button>
						</form>
					</div>

					<div class="tab-pane fade" id="create">
						
							<div class="form-group">
								<label for="name">Etunimi</label> <input type="name"
									class="form-control" name="enimi" placeholder="Etunimi">
							</div>
							<div class="form-group">
								<label for="name">Sukunimi</label> <input type="name"
									class="form-control" name="snimi" placeholder="Sukunimi">
							</div>
							<div class="form-group">
								<label for="email">Sähköposti</label> <input type="email"
									class="form-control" name="sahkoposti" placeholder="Sähköposti">
							</div>
							<div class="form-group">
								<label for="phone">Puhelin</label> <input type="phone"
									class="form-control" name="puhelin" placeholder="Puhelin">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Salasana</label> <input
									type="password" class="form-control" name="salasana"
									placeholder="Salasana">
							</div>
							<button type="submit" class="btn btn-default">Rekisteröidy</button>
							<button type="reset" class="btn btn-default">Tyhjennä</button>
						</form>
					</div>
				</div>
			</div>
		</div>

					</div>
				</div>
</body>
</html>
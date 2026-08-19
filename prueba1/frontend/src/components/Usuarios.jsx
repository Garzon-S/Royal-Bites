import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

export function Usuarios() {
  const navigate = useNavigate();
  const user = JSON.parse(localStorage.getItem('user')) || { nombre: 'Administrador' };

  // 1. La lista empieza vacía hasta traer los datos de Spring Boot
  const [listaUsuarios, setListaUsuarios] = useState([]);
  const [cargando, setCargando] = useState(true);

  // Estados para el Modal/Formulario
  const [mostrarModal, setMostrarModal] = useState(false);
  const [modoEdicion, setModoEdicion] = useState(false);

  const [formData, setFormData] = useState({
    tipoDocumento: 'CC',
    idPersona: '',
    pNombre: '',
    pApellido: '',
    correo: '',
    password: ''
  });

  // 2. Traer las personas de la BD al cargar el componente
  const cargarPersonasBD = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/personas');
      if (response.ok) {
        const data = await response.json();
        setListaUsuarios(data);
      }
    } catch (error) {
      console.error('Error al conectar con la base de datos:', error);
    } finally {
      setCargando(false);
    }
  };

  useEffect(() => {
    cargarPersonasBD();
  }, []);

  const handleLogout = () => {
    localStorage.removeItem('user');
    navigate('/login');
  };

  // Abrir modal para CREAR
  const abrirModalCrear = () => {
    setModoEdicion(false);
    setFormData({ tipoDocumento: 'CC', idPersona: '', pNombre: '', pApellido: '', correo: '', password: '' });
    setMostrarModal(true);
  };

  // Abrir modal para EDITAR
  const abrirModalEditar = (usuario) => {
    setModoEdicion(true);
    setFormData({
      tipoDocumento: usuario.tipoDocumento,
      idPersona: usuario.idPersona,
      pNombre: usuario.pNombre,
      pApellido: usuario.pApellido,
      correo: usuario.correo,
      password: usuario.password
    });
    setMostrarModal(true);
  };

  // Guardar en la Base de Datos mediante Spring Boot
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/api/personas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData)
      });

      if (response.ok) {
        setMostrarModal(false);
        cargarPersonasBD(); // Recargar la lista desde MySQL
      } else {
        alert('Error al guardar el usuario en la base de datos.');
      }
    } catch (error) {
      alert('Error de conexión con el servidor');
    }
  };

  return (
    <div className="dashboard-container">
      {/* Navbar Superior */}
      <header className="navbar">
        <div className="navbar-brand">
          <span>🍔</span> Sistema Royal Bites
        </div>
        <div className="navbar-user">
          <span>Hola, <strong>{user.nombre}</strong></span>
          <button onClick={handleLogout} className="btn-logout">Cerrar Sesión</button>
        </div>
      </header>

      {/* Contenido Principal */}
      <main className="dashboard-content">
        <div className="content-header">
          <div>
            <h2>Gestión de Usuarios</h2>
            <p>Personas registradas actualmente en la base de datos MySQL</p>
          </div>
          <button onClick={abrirModalCrear} className="btn-primary">+ Nuevo Usuario</button>
        </div>

        {/* Tabla de Usuarios */}
        <div className="table-card">
          {cargando ? (
            <p style={{ textAlign: 'center', padding: '20px' }}>Cargando datos de MySQL...</p>
          ) : (
            <table className="custom-table">
              <thead>
                <tr>
                  <th>Tipo / Documento</th>
                  <th>Nombre</th>
                  <th>Correo</th>
                  <th>Contraseña</th>
                  <th>Acciones</th>
                </tr>
              </thead>
              <tbody>
                {listaUsuarios.map((usr) => (
                  <tr key={`${usr.tipoDocumento}-${usr.idPersona}`}>
                    <td>{usr.tipoDocumento} - {usr.idPersona}</td>
                    <td className="font-bold">{usr.pNombre} {usr.pApellido}</td>
                    <td>{usr.correo}</td>
                    <td><code>{usr.password}</code></td>
                    <td>
                      <button 
                        onClick={() => abrirModalEditar(usr)} 
                        className="btn-action" 
                        title="Editar Datos"
                      >
                        ✏️
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      </main>

      {/* MODAL CREAR / EDITAR */}
      {mostrarModal && (
        <div className="modal-overlay">
          <div className="modal-content">
            <h3>{modoEdicion ? '✏️ Editar Usuario' : '➕ Crear Nuevo Usuario'}</h3>

            <form onSubmit={handleSubmit}>
              <div className="form-row">
                <div className="input-group">
                  <label>Tipo Documento</label>
                  <select 
                    value={formData.tipoDocumento} 
                    onChange={(e) => setFormData({...formData, tipoDocumento: e.target.value})}
                    disabled={modoEdicion}
                  >
                    <option value="CC">Cédula de Ciudadanía (CC)</option>
                    <option value="CE">Cédula de Extranjería (CE)</option>
                  </select>
                </div>

                <div className="input-group">
                  <label>Número Documento</label>
                  <input 
                    type="number" 
                    value={formData.idPersona} 
                    onChange={(e) => setFormData({...formData, idPersona: e.target.value})}
                    required 
                    disabled={modoEdicion}
                  />
                </div>
              </div>

              <div className="form-row">
                <div className="input-group">
                  <label>Primer Nombre</label>
                  <input 
                    type="text" 
                    value={formData.pNombre} 
                    onChange={(e) => setFormData({...formData, pNombre: e.target.value})}
                    required 
                  />
                </div>

                <div className="input-group">
                  <label>Primer Apellido</label>
                  <input 
                    type="text" 
                    value={formData.pApellido} 
                    onChange={(e) => setFormData({...formData, pApellido: e.target.value})}
                    required 
                  />
                </div>
              </div>

              <div className="input-group">
                <label>Correo Electrónico</label>
                <input 
                  type="email" 
                  value={formData.correo} 
                  onChange={(e) => setFormData({...formData, correo: e.target.value})}
                  required 
                />
              </div>

              <div className="input-group">
                <label>Contraseña</label>
                <input 
                  type="text" 
                  value={formData.password} 
                  onChange={(e) => setFormData({...formData, password: e.target.value})}
                  required 
                />
              </div>

              <div className="modal-actions">
                <button type="button" onClick={() => setMostrarModal(false)} className="btn-cancel">
                  Cancelar
                </button>
                <button type="submit" className="btn-primary">
                  {modoEdicion ? 'Actualizar BD' : 'Guardar en BD'}
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}
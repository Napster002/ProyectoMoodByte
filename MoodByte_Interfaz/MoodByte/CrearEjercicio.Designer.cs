namespace MoodByte
{
    partial class CrearEjercicio
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            lblEstado = new Label();
            lblTitulo = new Label();
            lblDescripcion = new Label();
            lblDuracion = new Label();
            cmbEstado = new ComboBox();
            txtTitulo = new TextBox();
            txtDescripcion = new TextBox();
            btnGuardar = new Button();
            buttonLimpiar = new Button();
            dtpDuracion = new DateTimePicker();
            epEjercicio = new ErrorProvider(components);
            lblUrl = new Label();
            txtUrl = new TextBox();
            ((System.ComponentModel.ISupportInitialize)epEjercicio).BeginInit();
            SuspendLayout();
            // 
            // lblEstado
            // 
            lblEstado.AutoSize = true;
            lblEstado.Location = new Point(263, 51);
            lblEstado.Name = "lblEstado";
            lblEstado.Size = new Size(57, 20);
            lblEstado.TabIndex = 0;
            lblEstado.Text = "Estado:";
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Location = new Point(263, 196);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(50, 20);
            lblTitulo.TabIndex = 1;
            lblTitulo.Text = "Titulo:";
            // 
            // lblDescripcion
            // 
            lblDescripcion.AutoSize = true;
            lblDescripcion.Location = new Point(223, 343);
            lblDescripcion.Name = "lblDescripcion";
            lblDescripcion.Size = new Size(90, 20);
            lblDescripcion.TabIndex = 2;
            lblDescripcion.Text = "Descripcion:";
            // 
            // lblDuracion
            // 
            lblDuracion.AutoSize = true;
            lblDuracion.Location = new Point(248, 124);
            lblDuracion.Name = "lblDuracion";
            lblDuracion.Size = new Size(72, 20);
            lblDuracion.TabIndex = 3;
            lblDuracion.Text = "Duracion:";
            // 
            // cmbEstado
            // 
            cmbEstado.FormattingEnabled = true;
            cmbEstado.Location = new Point(343, 51);
            cmbEstado.Margin = new Padding(3, 4, 3, 4);
            cmbEstado.Name = "cmbEstado";
            cmbEstado.Size = new Size(141, 28);
            cmbEstado.TabIndex = 4;
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(343, 196);
            txtTitulo.Margin = new Padding(3, 4, 3, 4);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(321, 27);
            txtTitulo.TabIndex = 5;
            // 
            // txtDescripcion
            // 
            txtDescripcion.Location = new Point(343, 340);
            txtDescripcion.Margin = new Padding(3, 4, 3, 4);
            txtDescripcion.Multiline = true;
            txtDescripcion.Name = "txtDescripcion";
            txtDescripcion.Size = new Size(321, 140);
            txtDescripcion.TabIndex = 6;
            // 
            // btnGuardar
            // 
            btnGuardar.Location = new Point(578, 521);
            btnGuardar.Margin = new Padding(3, 4, 3, 4);
            btnGuardar.Name = "btnGuardar";
            btnGuardar.Size = new Size(86, 31);
            btnGuardar.TabIndex = 8;
            btnGuardar.Text = "Guardar";
            btnGuardar.UseVisualStyleBackColor = true;
            btnGuardar.Click += btnGuardar_Click;
            // 
            // buttonLimpiar
            // 
            buttonLimpiar.Location = new Point(343, 521);
            buttonLimpiar.Margin = new Padding(3, 4, 3, 4);
            buttonLimpiar.Name = "buttonLimpiar";
            buttonLimpiar.Size = new Size(86, 31);
            buttonLimpiar.TabIndex = 9;
            buttonLimpiar.Text = "Limpiar";
            buttonLimpiar.UseVisualStyleBackColor = true;
            buttonLimpiar.Click += buttonLimpiar_Click;
            // 
            // dtpDuracion
            // 
            dtpDuracion.Format = DateTimePickerFormat.Time;
            dtpDuracion.Location = new Point(343, 124);
            dtpDuracion.Margin = new Padding(3, 4, 3, 4);
            dtpDuracion.Name = "dtpDuracion";
            dtpDuracion.Size = new Size(141, 27);
            dtpDuracion.TabIndex = 10;
            // 
            // epEjercicio
            // 
            epEjercicio.ContainerControl = this;
            // 
            // lblUrl
            // 
            lblUrl.AutoSize = true;
            lblUrl.Location = new Point(275, 268);
            lblUrl.Name = "lblUrl";
            lblUrl.Size = new Size(38, 20);
            lblUrl.TabIndex = 11;
            lblUrl.Text = "URL:";
            // 
            // txtUrl
            // 
            txtUrl.Location = new Point(343, 268);
            txtUrl.Name = "txtUrl";
            txtUrl.Size = new Size(321, 27);
            txtUrl.TabIndex = 12;
            // 
            // CrearEjercicio
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(914, 600);
            Controls.Add(txtUrl);
            Controls.Add(lblUrl);
            Controls.Add(dtpDuracion);
            Controls.Add(buttonLimpiar);
            Controls.Add(btnGuardar);
            Controls.Add(txtDescripcion);
            Controls.Add(txtTitulo);
            Controls.Add(cmbEstado);
            Controls.Add(lblDuracion);
            Controls.Add(lblDescripcion);
            Controls.Add(lblTitulo);
            Controls.Add(lblEstado);
            Margin = new Padding(3, 4, 3, 4);
            Name = "CrearEjercicio";
            Text = "CrearEjercicio";
            Load += CrearEjercicio_Load;
            ((System.ComponentModel.ISupportInitialize)epEjercicio).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblEstado;
        private Label lblTitulo;
        private Label lblDescripcion;
        private Label lblDuracion;
        private ComboBox cmbEstado;
        private TextBox txtTitulo;
        private TextBox txtDescripcion;
        private Button btnGuardar;
        private Button buttonLimpiar;
        private DateTimePicker dtpDuracion;
        private ErrorProvider epEjercicio;
        private TextBox txtUrl;
        private Label lblUrl;
    }
}